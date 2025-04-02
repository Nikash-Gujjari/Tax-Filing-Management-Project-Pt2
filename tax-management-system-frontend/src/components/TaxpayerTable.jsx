import axios from 'axios';
import { useState } from 'react';
import { Taxpayer } from '../models/Taxpayer.ts';
import React from 'react';

export const TaxpayerTable = (props) => {

    const [taxpayers, settaxpayers] = useState([]);

    // Use Cpa Params
    const getAllTaxpayers = async () => {
        await axios.get('http://localhost:8080/taxpayer')
                   .then(response => {
                        settaxpayers(response.data.map((taxpayer) => {
                            return {
                                taxpayer: new Taxpayer(taxpayer.taxpayer_id, taxpayer.first_name, taxpayer.middle_name, taxpayer.last_name, taxpayer.social_security_number, taxpayer.address, taxpayer.date_of_birth, taxpayer.bank_account_number, taxpayer.bank_routing_number)
                            }
                        }));
                   });
    }
    return (
        <div>
       
        <div>
             <div>
                <button onClick={() => getAllTaxpayers()}> Get All </button>
            </div>
        </div>
        <table>
                <thead>
                    <tr>
                        <th>Taxpayer Id</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Date of Birth</th>
                        <th>Social Security Number</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        taxpayers.map((taxpayer) => {
                            return (
                                <tr key={ taxpayer.taxpayer.taxpayer_id }>
                                    <td>{ taxpayer.taxpayer.first_name}</td>
                                    <td>{ taxpayer.taxpayer.last_name }</td>
                                    <td>{ taxpayer.taxpayer.date_of_birth }</td>
                                    <td>{ taxpayer.taxpayer.social_security_number }</td>
                                </tr>
                            )
                        })
                    }
                </tbody>
            </table>
        </div>

    );


};