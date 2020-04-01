import React, { Component } from "react";
import DatePicker from "react-datepicker";
import { Button, Form, FormGroup, Label, Input, FormText, Container } from 'reactstrap';
import "react-datepicker/dist/react-datepicker.css";
import "./App.css";
import { Link } from 'react-router-dom';

class Expense extends Component {

    constructor(props) {
        super(props)
        this.state = {
            date: new Date(),
            isLoading: true,
            expenses: [],
            categories: []
        }
    }

    async componentDidMount() {
        const response = await fetch('/api/category')
        const body = await response.json()
        this.setState({ categories: body, isLoading: false })
    }

    render() {
        const title = <h3>Add Expense</h3>
        const { categories, isLoading } = this.state
        if (isLoading) {
            return (<div>Loading...</div>)
        }
        else {

            let optionList =
                categories.map(category =>
                    <option>{category.name}</option>
                )


            return (
                <div>
                    <Container>
                        {title}
                        <Form>
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
                                <DatePicker selected={this.state.date} onChange={this.handleChange} />
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
                </div>
            )
        }

    }
}

export default Expense;