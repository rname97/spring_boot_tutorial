
import {useEffect, useState} from "react"
import { deleteEmployee, listEmployees } from "../services/EmployeeService"
import { useNavigate } from "react-router-dom"

const ListEmployeeComponent = () => {

    const [employees, setEmployees] = useState([])

    const navigator = useNavigate();

    useEffect(() => {
        getAllEmployee();
    }, []);

    function getAllEmployee(){
        listEmployees().then((response) => {
            setEmployees(response.data);
        }).catch(error => {
            console.error(error);
        })
    }

    function addNewEmployee(){
        navigator('/add-employee')
    }

    function updateEmployee(id){
        navigator(`/edit-employee/${id}`)
    }

    function viewEmployee(id){
        navigator(`/view-employee/${id}`)
    }

    function removeEmployee(id){
        console.log(id);
        deleteEmployee(id).then(() => {
            getAllEmployee();
        }).catch(error => {
            console.error(error);
        })
    }

  return (
    <div className="container">
        <h2 className="text-center">List of Employees</h2>
        <button className="btn btn-primary mb-2" onClick={addNewEmployee}>Add Employee</button>
        <table className="table table-striped table-bordered">
            <thead>
                <tr>
                    <td>Employee Id</td>
                    <td>Employee First Name</td>
                    <td>Employee Last Name</td>
                    <td>Employee Email Name</td>
                    <td>Action</td>
                </tr>
            </thead>
            <tbody>
                {
                    employees.map(employee =>
                        <tr key={employee.id}>
                            <td>{employee.id}</td>
                            <td>{employee.firstName}</td>
                            <td>{employee.lastName}</td>
                            <td>{employee.email}</td>
                            <td>
                                <button className="btn btn-info" onClick={() => viewEmployee(employee.id)} style={{marginLeft: '10px'}}>View</button>
                                <button className="btn btn-info" onClick={() => updateEmployee(employee.id)} style={{marginLeft: '10px'}}>Update</button>
                                <button className="btn btn-danger" onClick={() => removeEmployee(employee.id)} style={{marginLeft: '10px'}}>Delete</button>
                            </td>
                        </tr>
                    )
                }
            </tbody>
        </table>
    </div>
  )
}

export default ListEmployeeComponent
