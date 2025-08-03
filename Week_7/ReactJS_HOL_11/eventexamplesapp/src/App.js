import React from 'react';
import Counter from './Counter';
import WelcomeButton from './WelcomeButton';
import SyntheticEventButton from './SyntheticEventButton';
import CurrencyConvertor from './CurrencyConvertor';
import './App.css';

function App() {
  return (
    <div className="App">
      <Counter />
      <WelcomeButton />
      <SyntheticEventButton />
      <CurrencyConvertor />
    </div>
  );
}

export default App;