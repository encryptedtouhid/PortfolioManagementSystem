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

  return (
    <Modal
      isOpen={isOpen}
      onRequestClose={onRequestClose}
      contentLabel="Add Trade Modal"
    >
      <h2>Add Trade</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Trade Type:</label>
          <input
            type="text"
            value={tradeType}
            onChange={(e) => setTradeType(e.target.value)}
            required
          />
        </div>
        <div>
          <label>Trade Value:</label>
          <input
            type="number"
            value={tradeValue}
            onChange={(e) => setTradeValue(e.target.value)}
            required
          />
        </div>
        <div>
          <label>Instrument ID:</label>
          <input
            type="text"
            value={instrumentId}
            onChange={(e) => setInstrumentId(e.target.value)}
            required
          />
        </div>
        <button type="submit">Submit</button>
      </form>
    </Modal>
  );
}

export default AddTradePage;

