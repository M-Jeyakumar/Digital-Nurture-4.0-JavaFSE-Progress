import React from 'react';

function SyntheticEventButton() {
  const handlePress = (event) => {
    console.log(event); 
    alert('I was clicked!');
  };

  return (
    <div className="component-section">
      <h2>Synthetic Event Example</h2>
      <button onClick={handlePress}>Press Me (OnPress)</button>
    </div>
  );
}

export default SyntheticEventButton;