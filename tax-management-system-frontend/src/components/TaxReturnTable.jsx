import axios from 'axios';
import { useState } from 'react';
import { Tax_Return } from '../models/Tax_Return.ts';
import React from 'react';

export const TaxReturnTable = (props) => {

    const [taxreturns, setTaxReturns] = useState([]);

    // Use Cpa Params
    const getAllTaxReturns = async () => {
        await axios.get('http://localhost:8080/taxreturn')
                   .then(response => {
                        setTaxReturns(response.data.map((taxreturn) => {
                            return {
                                taxreturn: new Tax_Return(taxreturn.taxreturn_id, taxreturn.filing_status)
                            }
                        }));
                   });
    }
    return (
        <div>
        <div>
             <div>
                <button onClick={() => getAllTaxReturns()}> Get All </button>
            </div>
        </div>
        <table>
                <thead>
                    <tr>
                        <th>Tax Return Id</th>
                        <th>Filing Status</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        taxreturns.map((taxreturn) => {
                            return (
                                <tr key={ taxreturn.taxreturn.taxreturn_id }>
                                    <td>{ taxreturn.taxreturn.filing_status }</td>
                                </tr>
                            )
                        })
                    }
                </tbody>
            </table>
        </div>

    );


};