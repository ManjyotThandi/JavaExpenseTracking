import React, { Component } from 'react';
import AppNav from './AppNav';

class Home extends Component {
    state = {}

    render() {
        return (
            <>
                <div style={{display: 'flex', alignItems: 'center', justifyContent: 'center', height: '100vh'}}>
                    <h2>
                        Welcome to easy expense AppNav
                  </h2>
                </div>
            </>
        )
    }
}

export default Home;