import React, { Component } from "react";
import logo from './logo.svg';
import './App.css';
import UserComponent from './components/UserComponent';
import UploadFiles from "./components/UploadComponent";
import "bootstrap/dist/css/bootstrap.min.css";

/* https://www.bezkoder.com/react-file-upload-spring-boot/ */

function App() {
  return (
    <div className="App">
      <UploadFiles />
      <UserComponent />
    </div>
  );
}

export default App;
