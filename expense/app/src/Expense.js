import React, { Component } from "react";
import DatePicker from "react-datepicker";
import { Table, Button, Form, FormGroup, Label, Input, FormText, Container } from 'reactstrap';
import "react-datepicker/dist/react-datepicker.css";
import "./App.css";
import { Link } from 'react-router-dom';

class Expense extends Component {
    
        emptyItem = {
            description : '' ,
            expenseDate : new Date(),
            id:104,
            location : '',
            category : {id:1 , name:'Travel'}
        }

    constructor(props) {
        super(props)
        this.state = {
            isLoading: true,
            expenses: [],
            categories: [],
            item : this.emptyItem
        }

        this.handleSubmit = this.handleSubmit.bind(this)
        this.remove = this.remove.bind(this)
        this.handleChange = this.handleChange.bind(this)
        this.handleDateChange = this.handleDateChange.bind(this)
    }

    async componentDidMount() {
        const response = await fetch('/api/category')
        const body = await response.json()
        this.setState({ categories: body })

        const responseExp = await fetch('/api/expenses')
        const bodyExp = await responseExp.json()
        this.setState({ expenses: bodyExp, isLoading: false })
    }

    async remove(id) {
       await fetch(`/api/expenses/${id}`, {
            method: "DELETE",
            headers: {
                "Accept": "application/json",
                "Content-type": "application/json"
            }
        })
            .then(() => {
                let updatedExpenses = this.state.expenses.filter(i => i.id !== id)
                this.setState({ expenses: updatedExpenses })
            })
    }

    async handleSubmit(event){
        console.log('HERE')
        event.preventDefault();
        const {item} = this.state
        await fetch('/api/expense', {
            method: "POST",
            headers: {
                "Accept" : "application/json",
                "Content-type": "application/json"
            },
            body: JSON.stringify(item)
        })

        this.props.history.push("/expenses");
    }

    handleChange(event){
        const target = event.target
        const value = target.value
        const name = target.name
        let item = {...this.state.item};
        item[name] = value;
        this.setState({item});  
    }

    handleDateChange(date){
        let item = {...this.state.item}
        item.expenseDate = date;
        this.setState({item})
    }

    render() {

        const title = <h3>Add Expense</h3>
        const { categories, isLoading, expenses } = this.state
        if (isLoading) {
            return (<div>Loading...</div>)
        }
        else {

            let optionList =
                categories.map(category =>
                    <option>{category.name}</option>
                )


            let rows = expenses.map(expense =>
                <tr>
                    <td>{expense.description}</td>
                    <td>{expense.location}</td>
                    <td>{expense.expenseDate}</td>
                    <td>{expense.category.name}</td>
                    <td><Button size="sm" color="danger" onClick={() => { this.remove(expense.id) }}>Remove</Button></td>
                </tr>

            )


            return (
                <div>
                    <Container>
                        {title}
                        <Form onSubmit = {this.handleSubmit}>
                            <FormGroup>
                                <Label for="title">Title</Label>
                                <Input type="text" name="title" id="title" onChange={this.handleChange} />
                            </FormGroup>


                            <FormGroup>
                                <Label for="category">Category</Label>
                                <select>
                                    {optionList}
                                </select>
                                <Input type="text" name="category" id="category" onChange={this.handleChange} />
                            </FormGroup>

                            <FormGroup>
                                <Label for="expenseDate">Date</Label>
                                <DatePicker selected={this.state.item.expenseDate} onChange={this.handleDateChange} />
                            </FormGroup>

                            <FormGroup>
                                <Label for="location">Location</Label>
                                <Input type="text" name="location" id="location" onChange={this.handleChange} />
                            </FormGroup>


                            <FormGroup>
                                <Button color="primary" type="submit">Save</Button>
                                <Button color="secondary" tag={Link} to="/categories">Cancel</Button>
                            </FormGroup>

                        </Form>
                    </Container>

                    <Container>
                        <h3>Expenses</h3>
                        <Table className="mt-4">
                            <thead>
                                <tr>
                                    <th>Description</th>
                                    <th>Location</th>
                                    <th>Category</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                {rows}
                            </tbody>
                        </Table>
                    </Container>
                </div>
            )
        }

    }
}

export default Expense;