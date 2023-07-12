import React from 'react';
import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Home from "./pages/Home";
import Error404 from "./pages/Error404";
import Test from "./pages/Test";
import Login from "./components/Login";
import Shoe from "./pages/Shoe";
import Registration from "./pages/Registration";
import Navigation from "./components/Navigation";

function App() {
  return (
    <>
      <Navigation/>
      <main>
        <BrowserRouter>
          <Routes>
            <Route path="/" element={<Home/>}/>
            <Route path="/test" element={<Test/>}/>
            <Route path="*" element={<Error404/>}/>
            <Route path="/login" element={<Login/>}/>
            <Route path="/shoe/:id" element={<Shoe/>}/>
            <Route path="/register" element={<Registration/>}/>
          </Routes>
        </BrowserRouter>
      </main>
    </>
  );
}

export default App;
