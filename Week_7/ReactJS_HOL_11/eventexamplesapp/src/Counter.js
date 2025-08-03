import React, { Component } from 'react';

class Counter extends Component {
  constructor(props) {
    super(props);
    this.state = {
      count: 0,
    };
    this.handleIncrease = this.handleIncrease.bind(this);
    this.handleDecrease = this.handleDecrease.bind(this);
  }
  increment() {
    this.setState((prevState) => ({
      count: prevState.count + 1,
    }));
  }

  sayHello() {
    alert('Hello! The counter is increasing.');
  }

  handleIncrease() {
    this.increment();
    this.sayHello();
  }

  handleDecrease() {
    this.setState((prevState) => ({
      count: prevState.count - 1,
    }));
  }

  render() {
    return (
      <div className="component-section">
        <h2>Counter</h2>
        <p>Current Count: {this.state.count}</p>
        <button onClick={this.handleIncrease}>Increase</button>
        <button onClick={this.handleDecrease}>Decrease</button>
      </div>
    );
  }
}

export default Counter;