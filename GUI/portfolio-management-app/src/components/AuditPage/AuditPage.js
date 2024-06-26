import React, { useState, useEffect } from 'react';
import { fetchAuditLogs } from './auditService';

function AuditPage() {
  const [auditLogs, setAuditLogs] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const logs = await fetchAuditLogs();
        setAuditLogs(logs);
      } catch (error) {
        console.error('Error fetching audit logs:', error);
      }
    };

    fetchData();
  }, []);

  return (
    <div className="container">
      <h1 className="my-4">Audit Log</h1>
      <table className="table table-bordered">
        <thead className="thead-dark">
          <tr>
            <th>Audit ID</th>
            <th>Transaction Ref</th>
            <th>Instrument ID</th>
            <th>Trade Type</th>
            <th>Audit Date</th>
          </tr>
        </thead>
        <tbody>
          {auditLogs.map(log => (
            <tr key={log.Audit_ID}>
              <td>{log.Audit_ID}</td>
              <td>{log.Transaction_Ref}</td>
              <td>{log.Instrument_ID}</td>
              <td>{log.Trade_Type}</td>
              <td>{log.Audit_Date}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default AuditPage;
