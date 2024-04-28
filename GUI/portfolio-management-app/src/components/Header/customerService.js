import axios from 'axios';

export const fetchCustomerInfo = async () => {
  try {
    const response = await axios.get(`${process.env.REACT_APP_API_ENDPOINT}/getCustomerInfo`);
    return response.data;
  } catch (error) {
    console.error('Error fetching customer information:', error);
    throw error;
  }
};
