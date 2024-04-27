import React, { useState, useEffect } from 'react';

function AuditPage() {
  const [auditLogs, setAuditLogs] = useState([]);

  useEffect(() => {
    fetch(`${process.env.REACT_APP_API_ENDPOINT}/getAuditLog`)
      .then(response => response.json())
      .then(data => {
        setAuditLogs(data.audit_logs);
      })
      .catch(error => {
        console.error('Error fetching audit logs:', error);
      });
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
