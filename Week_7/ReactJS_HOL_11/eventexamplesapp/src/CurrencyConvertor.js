import React, { Component } from 'react';

const INR_TO_EURO_RATE = 0.011; 

class CurrencyConvertor extends Component {
  constructor(props) {
    super(props);
    this.state = {
      rupees: '',
      euros: 0,
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    this.setState({ rupees: event.target.value });
  }

  handleSubmit(event) {
    event.preventDefault();
    const rupees = parseFloat(this.state.rupees);
    if (!isNaN(rupees)) {
      const euros = rupees * INR_TO_EURO_RATE;
      this.setState({ euros: euros.toFixed(2) });
    } else {
      alert('Please enter a valid number for rupees.');
    }
  }

  render() {
    return (
      <div className="component-section">
        <h2>Currency Convertor</h2>
        <form onSubmit={this.handleSubmit}>
          <label>
            Indian Rupees (INR):
            <input
              type="text"
              value={this.state.rupees}
              onChange={this.handleChange}
            />
          </label>
          <button type="submit">Convert</button>
        </form>
        <p>
          Euros (EUR): €{this.state.euros}
        </p>
      </div>
    );
  }
}

export default CurrencyConvertor;