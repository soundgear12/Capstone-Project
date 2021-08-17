import React, { useState } from 'react';
import { Button, Form, FormGroup, Label, Input, FormText } from 'reactstrap';

const CreateAccount = () => {

    let [balance, setBalance] = useState({});
    let [unit] = useState('imperial');
    let [responseObj, setResponseObj] = useState({});
    let [error, setError] = useState(false);
    let [loading, setLoading] = useState(false);


    function getForecast(e) {
        e.preventDefault();
    
        if (balance.length === 0) {
            return setError(true);
        }
    
        // Clear state in preparation for new data
        setError(false);
        setResponseObj({});
        
        setLoading(true);
        

    
        fetch("http://localhost:8080/AccountHolders/1/PersonalCheckingAccount", {
            method: "POST",
            headers: {
                Accept: "application/json",
                "Content-Type": "application/json",
            },
            body: JSON.stringify({"balance": balance})


        })
        .then(response => response.json())
        .then(response => {
            console.log(response);
            if (response.cod !== 201) {
                throw new Error()
            }
    
            setResponseObj(response);
            setLoading(false);
        })
        .catch(err => {
            setError(true);
            setLoading(false);
            console.log(err.message);
        });
    }
    


  return (
    <Form  onSubmit={getForecast}>
        <FormGroup>
        <Label for="exampleSelect">Select Bank Account Type</Label>
        <Input type="select" name="select" id="exampleSelect">
          <option>PersonalCheckingAccount</option>
          <option>2</option>
          <option>3</option>
          <option>4</option>
          <option>5</option>
        </Input>
      </FormGroup>

      <FormGroup>
        <Label for="exampleBalance">Opening Balance</Label>
        <Input type="number" name="balance" id="exampleBalance" value={balance} placeholder="0.00" onChange={(e) => setBalance(e.target.value)}/>
      </FormGroup>
      
      
      
      
      
      <Button>Submit</Button>
    </Form>
  );
}

export default CreateAccount;