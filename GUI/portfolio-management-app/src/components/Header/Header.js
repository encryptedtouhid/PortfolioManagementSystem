import React, { useState, useEffect } from 'react';
import AddTradeModal from '../AddTradePage/AddTradePage';
import { fetchCustomerInfo } from './customerService';
import { toast, ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import InvestmentStrategies from '../../enums/InvestmentStrategies';


function Header() {
  const [customerInfo, setCustomerInfo] = useState({});
  const [isModalOpen, setIsModalOpen] = useState(false);

  const handleAddTradeClick = () => {
    setIsModalOpen(true);
  };

  useEffect(() => {
    const fetchData = async () => {
      try {
        const customerData = await fetchCustomerInfo();
        setCustomerInfo(customerData);
        toast.success('Customer information loaded successfully!');
      } catch (error) {
        toast.error('Error fetching customer information:');
      }
    };

    fetchData();
  }, []);

  const { CustomerName, PortfolioValue, InvestmentStrategy } = customerInfo;

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
      <button className="btn btn-primary" onClick={handleAddTradeClick}>Add Trade</button>
      <ToastContainer />
      <AddTradeModal isOpen={isModalOpen} onClose={() => setIsModalOpen(false)} />
      <p hidden>{InvestmentStrategies[InvestmentStrategy]}</p>
    </div>
  );
}

export default Header;
