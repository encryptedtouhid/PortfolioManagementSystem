// components/Header.js
import React from 'react';

function Header() {
  return (
    <div className="header-container">
      <div>
        <h1 className="d-inline-block mr-3">Customer Name</h1>
      </div>
      {/* <div className="d-inline-block">
        <h5 className="mr-3">PortFolio Number</h5>
        <h5 className="mr-3">Current Performance</h5>
        <h5>Investment Strategy</h5>
      </div> */}
      <button className="btn btn-primary">Add Trade</button>
    </div>
  );
}

export default Header;
