import axios from 'axios';

export const fetchPortfolioData = async () => {
  try {
    const response = await axios.get(`${process.env.REACT_APP_API_ENDPOINT}/portfolio`);
    return response.data;
  } catch (error) {
    console.error('Error fetching portfolio data:', error);
    throw error;
  }
};
