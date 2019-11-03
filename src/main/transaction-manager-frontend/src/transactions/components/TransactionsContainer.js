import React, {Component} from 'react';
import {Table} from 'react-bootstrap';
import * as transactionActions from '../actions/TransactionActions'
import TransactionsTableRow from "./forms/TransactionsTableRow";
import TransactionInfoModal from "./forms/TransactionInfoModal";

export default class TransactionsContainer extends Component {

    constructor(props) {
        super(props);
        this.state = {
            transactions: [],
            modalTransaction: {},
            modalOpened: false
        };
    }

    componentDidMount() {
        transactionActions.fetchTransactions().then((response) => {
            this.setState({transactions: response.data});
        });
    };

    openTransactionInfo = (transaction) => {
        this.setState({modalTransaction: transaction, modalOpened: true})
    };

    closeTransactionInfo = () => {
        this.setState({modalOpened: false, modalTransaction: {}})
    };

    render() {
        const {transactions, modalOpened, modalTransaction} = this.state;
        return (
            <>
                <Table striped bordered condensed hover>
                    <thead>
                    <tr>
                        <th scope="col">Type</th>
                        <th scope="col">Amount</th>
                    </tr>
                    </thead>
                    <tbody>

                    {
                        transactions && transactions.map(transaction => {
                            return <TransactionsTableRow transaction={transaction}
                                                         openTransactionInfo={this.openTransactionInfo}/>
                        })
                    }
                    </tbody>
                </Table>
                <TransactionInfoModal show = {modalOpened}
                                      transaction={modalTransaction}
                                      handleClose={this.closeTransactionInfo}/>
            </>
        )
    }
}