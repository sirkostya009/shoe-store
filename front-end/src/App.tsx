import React from 'react';
import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Home from "./pages/Home";
import Error404 from "./pages/Error404";
import Test from "./pages/Test";
import Layout from "./components/Layout";
import Login from "./components/Login";
import Shoe from "./pages/Shoe";
import Registration from "./pages/Registration";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="*" element={
          <Layout children={
            <Routes>
              <Route path="/" element={<Home/>}/>
              <Route path="/test" element={<Test/>}/>
              <Route path="*" element={<Error404/>}/>
              <Route path="/login" element={<Login/>}/>
              <Route path="/shoe/:id" element={<Shoe/>}/>
              <Route path="/register" element={<Registration/>}/>
            </Routes>
          }/>
        }/>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
