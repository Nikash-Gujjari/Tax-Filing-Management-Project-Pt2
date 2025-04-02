import axios from 'axios';
import { useState } from 'react';
import { Cpa }  from '../models/Cpa';
import React from 'react';
import '../css/HomePage.css'; 

export const CpaTable = () => {

    const [cpas, setCpas] = useState([]);

    const [cpaFormVisible, setCpaFormVisible] = useState(false);

    const getAllCpas = async () => {
        await axios.get('http://localhost:8080/cpa')
                   .then(response => {
                        console.log(response.data);
                        setCpas(response.data.map((cpa) => {
                            return {
                                cpa: new Cpa(cpa.cpa_id, cpa.first_name, cpa.last_name, cpa.email, cpa.username, cpa.password, cpa.role)
                            }
                        }));
                   });};
    const deleteCpa = async (id) => {
        await axios.delete(`http://localhost:8080/cpa/${id}`).then(async () => {
            await getAllCpas(null);
       });
    };

    const editCpa = () => {
        console.log('Help');
    }
    

    return (
        <>
        <div>
            <form class="centerForm">

            </form>
        </div>
        <div>
            <button onClick={() => getAllCpas()}> Get All </button>
        </div>
        <table>
                <thead>
                    <tr>
                        <th>CPA Id </th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Role</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        cpas.map((cpa) => {
                            return (
                                <tr key={ cpa.cpa.cpa_id }>
                                    <td>{ cpa.cpa.cpa_id }</td>
                                    <td>{cpa.cpa.first_name}</td>
                                    <td>{ cpa.cpa.last_name }</td>
                                    <td>{ cpa.cpa.email }</td>
                                    <td>{ cpa.cpa.role }</td>
                                    <td><button onClick={() => editCpa(cpa.cpa.cpa_id)}> Edit </button></td>
                                    <td><button onClick={() => deleteCpa(cpa.cpa.cpa_id)}> Delete </button></td>
                                </tr>
                            )
                        })
                    }
                </tbody>
            </table>
        </>
    );


};