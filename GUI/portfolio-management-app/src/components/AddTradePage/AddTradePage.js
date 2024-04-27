import React, { useState } from 'react';
import Modal from 'react-modal';

Modal.setAppElement('#root'); // Set the root element for accessibility

function AddTradePage({ isOpen, onRequestClose, onSubmit }) {
  const [tradeType, setTradeType] = useState('');
  const [tradeValue, setTradeValue] = useState('');
  const [instrumentId, setInstrumentId] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    onSubmit({ tradeType, tradeValue, instrumentId });
  };

  const customStyles = {
    content: {
      top: '50%',
      left: '50%',
      right: 'auto',
      bottom: 'auto',
      marginRight: '-50%',
      transform: 'translate(-50%, -50%)',
      maxWidth: '600px', // Set maximum width if needed
      width: '90%', // Set width as required
    },
    overlay: {
      backgroundColor: 'rgba(0, 0, 0, 0.5)', // Dim the background
    },
  };

  return (
    <Modal
      isOpen={isOpen}
      onRequestClose={onRequestClose}
      contentLabel="Add Trade Modal"
      style={customStyles}
    >
      <div className="modal-header">
        <h2>Add Trade</h2>
        <button className="close-btn" onClick={onRequestClose}>×</button>
      </div>
      <div className="modal-body">
        <form onSubmit={handleSubmit}>
          <div className="form-group">
            <label>Trade Type:</label>
            <input
              type="text"
              value={tradeType}
              onChange={(e) => setTradeType(e.target.value)}
              required
              className="form-control"
            />
          </div>
          <div className="form-group">
            <label>Trade Value:</label>
            <input
              type="number"
              value={tradeValue}
              onChange={(e) => setTradeValue(e.target.value)}
              required
              className="form-control"
            />
          </div>
          <div className="form-group">
            <label>Instrument ID:</label>
            <input
              type="text"
              value={instrumentId}
              onChange={(e) => setInstrumentId(e.target.value)}
              required
              className="form-control"
            />
          </div>
          <button type="submit" className="btn btn-primary">Submit</button>
        </form>
      </div>
    </Modal>
  );
}

export default AddTradePage;
