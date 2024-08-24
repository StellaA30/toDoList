import React, { Component } from 'react';
import { connect } from 'react-redux';

class LogInPage extends Component {
    render() {
        return (
            <div>
                Hi
                
            </div>
        );
    }
}

function mapStateToProps(state) {
    return {
        users: state.users,

    };
}

export default connect(
    mapStateToProps,
)(LogInPage);