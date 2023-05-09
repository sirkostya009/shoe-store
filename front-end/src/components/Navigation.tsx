import { NavLink } from 'react-router-dom';
import '../styles/Navigation.css';
import {useUser} from "../hooks";

function Navigation() {
  const {user, logout} = useUser();

  return (
    <nav className="navbar navbar-expand-lg navbar-light bg-light">
      <div className="container-fluid">
        <NavLink to="/" className="navbar-brand">My Shoe Store</NavLink>
        <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarNav">
          <ul className="navbar-nav">
            {user ?
              <li className="nav-item">
                <NavLink to={""} className="nav-link">{user.name}</NavLink>
              </li>
              :
              <li className="nav-item">
                <NavLink to="/register" className="nav-link">Register</NavLink>
              </li>
            }
            {user ?
              <li className="nav-item">
                <button onClick={logout} className="nav-link">Logout</button>
              </li>
              :
              <li className="nav-item">
                <NavLink to="/login" className="nav-link">Login</NavLink>
              </li>
            }
          </ul>
        </div>
      </div>
    </nav>
  );
}

export default Navigation;
