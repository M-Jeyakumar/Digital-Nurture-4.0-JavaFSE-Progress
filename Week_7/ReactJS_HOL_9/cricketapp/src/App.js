import React from 'react';
import './App.css';
import { ListofPlayers, Scorebelow70 } from './ListofPlayers';
import { OddPlayers, EvenPlayers, ListofIndianPlayers } from './IndianPlayers';

function App() {

  const flag = false;

  if (flag === true) {
    return (
      <div className="App">
        <h1>List of Players</h1>
        <ListofPlayers />
        <hr />
        <h1>List of Players having Scores Less than 70</h1>
        <Scorebelow70 />
      </div>
    );
  } else {
    return (
      <div className="App">
        <h1>Odd Players</h1>
        <OddPlayers />
        <hr />
        <h1>Even Players</h1>
        <EvenPlayers />
        <hr />
        <h1>List of Indian Players Merged:</h1>
        <ListofIndianPlayers />
      </div>
    );
  }
}

export default App;