import axios from 'axios';
import { useState } from 'react';
import { Cpa }  from '../models/Cpa';
import React from 'react';
import {useRef} from 'react';


export const CpaForm = (props) => {



    const newFirstName = useRef('');
    const newLastName = useRef('');
    const newEmail = useRef('');
    const newUsername = useRef('');
    const newPassword = useRef('');
    const newRole = useRef('');

    const alterUser = async(event) => {
        event.preventDefault();
        await axios.put(`http://localhost:8080/cpa/${props.id}`,
            {
                first_name: newFirstName.current.value,
                last_name: newLastName.current.value,
                email: newEmail.current.value,
                username: newEmail.current.value,
                password: newPassword.current.value,
                role: newRole.current.value,
            }.then(async () => {
                await axios.get('http://localhost:8080/cpa');
            })
        )

    }
    <form onSubmit={() => alterUser()}>
        <label for="First Name"> First Name: </label>
        <input type="text" ref={newFirstName} />
        <label for="Last Name"> Last Name: </label>
        <input type="text" ref={newLastName} />
        <label for="Email"> Email: </label>
        <input type="text" ref={newEmail} />
        <label for="Username"> Username: </label>
        <input type="text" ref={newUsername} />
        <label for="Password"> Password: </label>
        <input type="text" ref={newPassword} />
        <label for="Role"> Role: </label>
        <input type="text" ref={newRole} />
        <button type="submit" onClick={() => props.setter(false)}> Submit </button>
        <button onClick={() => props.setter(false)}> Close </button>
    </form>

}