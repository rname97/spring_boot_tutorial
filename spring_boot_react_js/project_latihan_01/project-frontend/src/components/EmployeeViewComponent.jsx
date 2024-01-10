import { useEffect, useState } from "react"
import { getEmployee } from "../services/EmployeeService"
import { useNavigate, useParams } from "react-router-dom"

function EmployeeViewComponent() {
    const [firstName, setFirstName] = useState('')
    const [lastName, setLastName] = useState('')
    const [email, setEmail] = useState('')

    const {id} = useParams();

    const navigator = useNavigate();

    useEffect(() => {
        if(id){
            getEmployee(id).then((response) => {
                setFirstName(response.data.firstName);
                setLastName(response.data.lastName);
                setEmail(response.data.email);
            }).catch(error => {
                console.error(error); 
            })
        }
    }, [id])

    function backEmployeesList(){
        navigator('/employees')
    }

  return (
    <div className="container">
        <br /> <br />
        <div className="row">
            <div className="card col-md-6 offset-md-3 offset-md-3">
               
                <div className="card-body">
              
                        <div className="form-group mb-2">
                            <label className="form-label">First Name : </label>
                            <span> {firstName}</span>
                        </div>
                        <div className="form-group mb-2">
                            <label className="form-label">Last Name : </label>
                            <span> {lastName}</span>
                        </div>
                        <div className="form-group mb-2">
                            <label className="form-label">Email : </label>
                            <span> {email}</span>
                        </div>

                        <button className="btn btn-secondary" onClick={backEmployeesList} style={{marginLeft: '10px'}}>Back</button>
                        
              
                </div>
            </div>
        </div>
    </div>
  )
}

export default EmployeeViewComponent
