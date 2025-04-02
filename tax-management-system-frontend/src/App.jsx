import './App.css';
import React, { useState } from 'react';
import { LoginPage } from './pages/LoginPage';
import { HomePage } from './pages/HomePage';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import { useNavigate } from "react-router";

function App() {
  const navigate = useNavigate();

  const [id, setId] = useState(0);

  return (
    <div>
        <Routes>
          <Route path="/home" element={<HomePage  id={id}/>} />
          <Route path="/" element={<LoginPage  setter={setId}/>} />
        </Routes>
    </div>
  );
}

export default App;
