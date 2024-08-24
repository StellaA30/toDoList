import React, { Component } from 'react';
import { connect } from 'react-redux';
import * as userActions from "../redux/actions/userActions";
import PropTypes from "prop-types";


class LogInPage extends Component {


    componentDidMount() {
        const { users, getUserData} = this.props;
        if(users.length === 0) {
            getUserData().catch((error) => {
                alert("loading users failed" + error)

            })
        }

    }



    render() {
        return (
            <div>
                Hi
                
            </div>
        );
    }
}

LogInPage.propTypes = {
    users: PropTypes.array,
    getUserData: PropTypes.func
}


// can be written as function or const
const mapStateToProps = (state) => ({
    users: state.users,
    tasks: state.tasks,
})

// manual mapping for mapDispatchToProps
// you can also pass in props to mapDispatchToProps if you define navigations, props.history.push('/')
const mapDispatchToProps = (dispatch) => ({
     getUserData : () => dispatch(userActions.fetchUserData()),

})


export default connect(
    mapStateToProps, mapDispatchToProps
)(LogInPage);