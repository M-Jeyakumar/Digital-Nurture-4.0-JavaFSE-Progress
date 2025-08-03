import React from 'react';

function WelcomeButton() {
  const handleClick = (message) => {
    alert(message);
  };

  return (
    <div className="component-section">
      <h2>Argument Passing Example</h2>
      <button onClick={() => handleClick('Welcome')}>Say Welcome</button>
    </div>
  );
}

export default WelcomeButton;