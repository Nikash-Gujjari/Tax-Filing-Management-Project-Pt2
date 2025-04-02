import React from 'react';
import '../css/HomePage.css';
import { useNavigate } from "react-router";
import { useState } from 'react';
import { TaxReturnTable } from '../components/TaxReturnTable.jsx';
import { CpaTable } from '../components/CpaTable.jsx';
import { TaxpayerTable } from '../components/TaxpayerTable.jsx';
import { FormTable } from '../components/FormTable.jsx';
import { CpaForm } from '../components/CpaForm.jsx';
import Popup from 'reactjs-popup';

export const HomePage = (props) => {

  // Pop up for current logged in user information
  const [isUserPopupOpen, setUserPopupOpen] = useState(false);
                        

  // Showing One of The Tables at A Time
  const [activeTable, setTable] = useState("None");

  const showTable = (tableName) => {
    setTable(tableName);
  }
   // Route Navigation
  const navigate = useNavigate();

  // Action For Pressing the Logout Button
  const goToLogin = () => {
    navigate('/');
  };

  // Creating a New Item in the Active table

  const createEntry = (tableName) => {
    switch(tableName) {
      case "Cpa":
        break;
      case "Taxpayer":
        break;
      case "Tax Return":
        break;
      case "Form":
        break;
    }
  }


  return (
  <div>
    <div>
        {isUserPopupOpen && <CpaForm id={props.id} userpopup={isUserPopupOpen} setter={setUserPopupOpen}/>}
    </div>
      <div>
        <div className="home_header">
          <h1 className="home_h1">Tax Management System</h1>
          <button className="home_profile" onClick={() => setUserPopupOpen(true)}></button>
          <button className="home_logout" onClick={() => goToLogin}></button>
        </div>
          <nav className="home_navbar">
            <ul>
              <li className="home_table_header"><strong>Tables</strong></li>
              <li className="home_tables"><button onClick={() => showTable("Cpa")} disabled={props.id === 1} class="home_table_button">Certified Public Accountants</button>
              </li>
              <li className="home_tables"><button onClick={() => showTable("Taxpayer")} class="home_table_button">Taxpayers</button></li>
              <li className="home_tables"><button onClick={() => showTable("Tax Return")} class="home_table_button">Tax Returns</button></li>
              <li className="home_tables"><button onClick={() => showTable("Form")} class="home_table_button">Forms</button></li>
            </ul>
          </nav>
          <div className="home_actions">
            <button disabled={activeTable === "None"}>Create</button>
            <button disabled={activeTable === "None"}>Sort</button>
          </div>
          <div class="content">
            {activeTable === "Cpa" && <CpaTable />}
            {activeTable === "Taxpayer" && <TaxpayerTable />}
            {activeTable === "Tax Return" && <TaxReturnTable id={props.id} />}
            {activeTable === "Form" && <FormTable />}
          </div>

      </div>
    </div>
  );
}