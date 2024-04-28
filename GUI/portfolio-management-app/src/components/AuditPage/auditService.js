import axios from 'axios';

export const fetchAuditLogs = async () => {
  try {
    const response = await axios.get(`${process.env.REACT_APP_API_ENDPOINT}/getAuditLog`);
    return response.data.audit_logs;
  } catch (error) {
    console.error('Error fetching audit logs:', error);
    throw error;
  }
};
