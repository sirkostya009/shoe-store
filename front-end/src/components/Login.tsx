import React, { useState } from "react";
import {AuthenticationRequest} from "../model/requests";
import {useNavigate} from "react-router-dom";
import {useUser} from "../hooks";

function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState<string>();
  const navigate = useNavigate();
  const { login } = useUser();

  const onUsernameChange = (event: React.ChangeEvent<HTMLInputElement>) => setUsername(event.target.value);

  const onPasswordChange = (event: React.ChangeEvent<HTMLInputElement>) => setPassword(event.target.value);

  const authenticate = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();

    const request: AuthenticationRequest = { login: username, password };

    fetch("http://localhost:8000/users/authenticate", {
      method: "POST",
      body: JSON.stringify(request),
      headers: {
        'Content-Type': 'application/json'
      }
    })
      .then((response) => {
        const json = response.json();

        if (response.ok) {
          json.then(login).then(() => navigate(-1));
        } else {
          json.then((error) => setError(error?.message));
        }
      });
  }

  return (
    <div className="container mt-4">
      <h1>Login</h1>
      {error && <div className="alert alert-danger">{error}</div>}
      <form onSubmit={authenticate}>
        <div className="mb-3">
          <label htmlFor="username" className="form-label">Username</label>
          <input type="text" className="form-control" id="username" onChange={onUsernameChange} />
        </div>
        <div className="mb-3">
          <label htmlFor="password" className="form-label">Password</label>
          <input type="password" className="form-control" id="password" onChange={onPasswordChange} />
        </div>
        <button type="submit" className="btn btn-primary">Submit</button>
      </form>
    </div>
  );
}

export default Login;
