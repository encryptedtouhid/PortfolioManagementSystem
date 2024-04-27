import React, { useState, useEffect } from 'react';
import axios from 'axios';

function PortfolioDetailsPage() {
  const [portfolioData, setPortfolioData] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchData = async () => {
      try {
        // Check if data is already cached in local storage
        const cachedData = localStorage.getItem('portfolioData');
        if (cachedData) {
          setPortfolioData(JSON.parse(cachedData));
          setLoading(false);
        } else {
          const response = await axios.get('http://localhost:5000/portfolio');
          const responseData = response.data;
          // Update state with fetched data
          setPortfolioData(responseData);
          setLoading(false);
          // Cache data in local storage
          localStorage.setItem('portfolioData', JSON.stringify(responseData));
        }
      } catch (error) {
        console.error('Error fetching portfolio data:', error);
        setLoading(false);
      }
    };

    fetchData();

    // Optionally, you can clear the cache after a certain period of time
    // setTimeout(() => {
    //   localStorage.removeItem('portfolioData');
    // }, expirationTimeInMilliseconds);

  }, []);

  return (
    <div>
      <h2>Portfolio Details</h2>
      {loading ? (
        <div>Loading...</div>
      ) : (
        <table className="table">
          <thead>
            <tr>
              <th>Customer ID</th>
              <th>Customer Name</th>
              <th>Portfolio Number</th>
              <th>Portfolio Value</th>
              <th>Current Performance</th>
              <th>Investment Strategy</th>
            </tr>
          </thead>
          <tbody>
            {portfolioData.map((portfolio, index) => (
              <tr key={index}>
                <td>{portfolio.customerId}</td>
                <td>{portfolio.customerName}</td>
                <td>{portfolio.portfolioNumber}</td>
                <td>${portfolio.portfolioValue}</td>
                <td>{portfolio.currentPerformance}%</td>
                <td>{portfolio.investmentStrategy}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
}

export default PortfolioDetailsPage;
