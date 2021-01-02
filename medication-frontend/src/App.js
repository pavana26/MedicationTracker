import logo from './logo.svg';
import './App.css';
import {BrowserRouter as Router ,Route,Switch} from 'react-router-dom';
import Login from './components/Login';
import UserMedicinesListModal from './components/UserMedicinesListModal';
import AddMedicine from './components/AddMedicine';
import CreateUserMedicine from './components/CreateUserMedicine';
import Header from './components/Header';
import Footer from './components/Footer';
import Success from './components/Success';
import Error from './components/Error';
import Registration from './components/Registration';
function App() {
  return (
    <div>
      <Router>
       
        <Header/>
        <div className="container">
          <Switch>
            <Route path="/" exact component= {Login}></Route>
            <Route path="/register" exact component= {Registration}></Route>
            <Route path="/dashboard/:uid" exact component= {UserMedicinesListModal}></Route>
            <Route path="/addmedicine/:uid" exact component= {AddMedicine}></Route>
            <Route path="/addusermedicines/:id/:uid" component= {CreateUserMedicine}></Route>   
            <Route path="/success" component= {Success}></Route> 
            <Route path="/error" component= {Error}></Route>   
          </Switch>
        </div>
        <Footer/>
      
     </Router>
    </div>
  );
}

export default App;
