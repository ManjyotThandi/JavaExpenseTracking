import React, {Component} from 'react';

class Category extends Component {
    state = { 
        isLoading : true,
        Categories: []
    }

    // This is an async function. No need to use .then(), use await. wait for the fetch to occur, convert it into json, and then set the state.
    async componentDidMount() {
        const response = await fetch('/api/category')
        const body = await response.json();
        this.setState({Categories : body, isLoading: false})
    }

    render() {
        const {Categories, isLoading} = this.state;
        if(isLoading){
            return (<div>Loading...</div>)
        }
        else{
            return(
                <div>
                    <h2>Categories</h2>
                    {
                        Categories.map(category => 
                            <div id ={category.id} key={category.id}>
                                {category.name}
                            </div>
                        )
                    }
                </div>
            )
        }
    }
}

export default Category;