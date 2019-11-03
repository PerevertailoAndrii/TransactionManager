import React, {Component} from 'react';
import {Modal, Button} from 'react-bootstrap';

export default class TransactionInfoModal extends Component {

    render() {
        const {show, handleClose, transaction} = this.props;
        return (
            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Transaction info</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    Transaction with id = {transaction.id}
                    <br/>
                    created on = {transaction.effectiveDate}
                    <br/>
                    transaction type is = {transaction.type}
                    <br/>
                    transaction amount is = {transaction.amount}
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={handleClose}>
                        Close
                    </Button>
                </Modal.Footer>
            </Modal>
        );
    }
}