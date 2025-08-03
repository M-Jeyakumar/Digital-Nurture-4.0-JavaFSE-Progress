import React from 'react';
import './App.css';

function App() {
  const heading = "Office Space";

  const officeImage = "https://images.pexels.com/photos/260689/pexels-photo-260689.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1";
  const imageElement = <img src={officeImage} width="25%" height="25%" alt="Office Space" />;
  
  const office = {
    Name: 'DBS',
    Rent: 50000,
    Address: 'Chennai'
  };

  const officeList = [
    { Name: 'Cowrks', Rent: 75000, Address: 'Bengaluru' },
    { Name: 'WeWork', Rent: 45000, Address: 'Mumbai' },
    { Name: 'Regus', Rent: 80000, Address: 'Delhi' }
  ];

  return (
    <div className="container">
      <h1>{heading}, at Affordable Range</h1>
      {imageElement}

      <h2>Name: {office.Name}</h2>
      <h3 style={{ color: office.Rent <= 60000 ? 'red' : 'green' }}>
        Rent: Rs. {office.Rent}
      </h3>
      <h3>Address: {office.Address}</h3>

      <hr />
      <h1>More Office Spaces</h1>
      {officeList.map((space, index) => (
        <div key={index} className="office-card">
          <h2>Name: {space.Name}</h2>
          <h3 style={{ color: space.Rent <= 60000 ? 'red' : 'green' }}>
            Rent: Rs. {space.Rent}
          </h3>
          <h3>Address: {space.Address}</h3>
        </div>
      ))}
    </div>
  );
}

export default App;