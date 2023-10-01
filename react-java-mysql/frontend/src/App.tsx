import React, { FormEvent, useEffect, useState } from "react";
import "./App.css";

type Greeting = {
  id: number;
  name: string;
};

function App() {
  const [message, setMessage] = useState('');
  const [greeting, setGreeting] = useState<Greeting>();

  let handleClick= async (e: any) => {
    console.log('button clicked')
    e.preventDefault();
    try {
      let res = await fetch("/api/greetings", {
        method: "POST",
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ name: message }),
      });
      let resJson = await res.json();
      if (res.status === 201) {
        console.log('ok')
        setMessage("");
        setGreeting(resJson);
      } else {
        setMessage("Some error occured");
        console.log(res)
      }
    } catch (err) {
      console.log(err);
    }
  };


  return (
    <div className="App">
      <header className="App-header">
        <div>
          <h1>Welcome to my app</h1>
        </div>
        <textarea id="message" name="message" value={message} onChange={e => setMessage(e.target.value)} rows={4} cols={40}>
        </textarea>
        <br /> 
        <button type="submit" onClick={handleClick}>Submit form</button>
        {greeting ? (
          <p> you have sent this message: {greeting.name}</p>
        ) : (
          <p>Leave a greeting for your friendly security architect</p>
        )}
      </header>
    </div>
  );

}

export default App;
