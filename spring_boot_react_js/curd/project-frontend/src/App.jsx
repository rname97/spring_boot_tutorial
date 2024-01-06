import './App.css'
import { BrowserRouter, Routes, Route } from "react-router-dom";
import HomePage from './page/HomePage';
import HeaderComponent from './components/HeaderComponent';
import EmployeeComponent from './components/EmployeeComponent';
import ListEmployeeComponent from './components/ListEmployeeComponent';
import EmployeeViewComponent from './components/EmployeeViewComponent';

function App() {

  return (
    <>
      <HeaderComponent />
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<HomePage />}></Route>
          <Route path='/home' element={<HomePage />}></Route>
          <Route path='/employees' element={<ListEmployeeComponent />}></Route>
          <Route path='/add-employee/' element={<EmployeeComponent />}></Route>
          <Route path='/edit-employee/:id' element={<EmployeeComponent />}></Route>
          <Route path='/view-employee/:id' element={<EmployeeViewComponent />}></Route>
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
