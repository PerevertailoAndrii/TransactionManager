import React, {Component} from 'react';

export default class TransactionsTableRow extends Component {

    constructor(props) {
        super(props);
    }

    onOpenTransactionInfoClicked = (e) => {
        e.preventDefault();
        e.stopPropagation();
        const {transaction, openTransactionInfo} = this.props;
        openTransactionInfo(transaction);
    };

    render() {
        const {transaction} = this.props;
        const creditRowsClassName = transaction.type === "credit" ? "table-danger clickable" : "clickable";
        return (
            <tr className={creditRowsClassName} onClick={this.onOpenTransactionInfoClicked}>
                <td>{transaction.type}</td>
                <td>{transaction.amount}</td>
            </tr>

        )
    }
}