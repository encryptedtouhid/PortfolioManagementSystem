import React, { useState, useEffect } from 'react';
import axios from 'axios';

function Header() {
  const [customerInfo, setCustomerInfo] = useState({});

  useEffect(() => {
    const fetchCustomerInfo = async () => {
      try {
        const response = await axios.get(`${process.env.REACT_APP_API_ENDPOINT}/getCustomerInfo`);
        const customerData = response.data;
        setCustomerInfo(customerData);
      } catch (error) {
        console.error('Error fetching customer information:', error);
      }
    };

    fetchCustomerInfo();
  }, []);

  const { CustomerName, PortfolioValue } = customerInfo;

  return (
    <div className="header-container">
      <div>
        <h1 className="d-inline-block mr-3">{CustomerName}</h1>
        &nbsp;
        &nbsp;
        {PortfolioValue && (
          <p className="d-inline-block"> ( Portfolio Number: {PortfolioValue} )</p>
        )}
      </div>
      <button className="btn btn-primary">Add Trade</button>
    </div>
  );
}

export default Header;
