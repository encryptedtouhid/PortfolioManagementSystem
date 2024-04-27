import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Pagination from 'react-js-pagination';

function PortfolioDetailsPage() {
  const [portfolioData, setPortfolioData] = useState([]);
  const [loading, setLoading] = useState(true);
  const [activePage, setActivePage] = useState(1);
  const itemsPerPage = 10; // Number of items per page

  useEffect(() => {
    const fetchData = async () => {
      try {
        const cachedData = localStorage.getItem('portfolioData');
        if (cachedData) {
          setPortfolioData(JSON.parse(cachedData));
          setLoading(false);
        } else {
          const response = await axios.get(`${process.env.REACT_APP_API_ENDPOINT}/portfolio`);
          const responseData = response.data;
          setPortfolioData(responseData);
          setLoading(false);
          localStorage.setItem('portfolioData', JSON.stringify(responseData));
        }
      } catch (error) {
        console.error('Error fetching portfolio data:', error);
        setLoading(false);
      }
    };

    fetchData();
  }, []);

  const handlePageChange = (pageNumber) => {
    setActivePage(pageNumber);
  };

  const indexOfLastItem = activePage * itemsPerPage;
  const indexOfFirstItem = indexOfLastItem - itemsPerPage;
  const currentItems = portfolioData.slice(indexOfFirstItem, indexOfLastItem);

  return (
    <div className="container mt-4">
      <h2>Portfolio Details</h2>
      {loading ? (
        <div>Loading...</div>
      ) : (
        <>
          <table className="table table-striped table-bordered">
            <thead className="thead-dark">
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
              {currentItems.map((portfolio, index) => (
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
          <Pagination
            activePage={activePage}
            itemsCountPerPage={itemsPerPage}
            totalItemsCount={portfolioData.length}
            pageRangeDisplayed={5}
            onChange={handlePageChange}
            itemClass="page-item"
            linkClass="page-link"
          />
        </>
      )}
    </div>
  );
}

export default PortfolioDetailsPage;
