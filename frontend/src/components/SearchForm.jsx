import React from 'react';

import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';

const SearchForm = (props) => {
    return (
        <>
            <Form>
                <Form.Group>
                    <Row>
                    <Col>
                        <Form.Control type="search" placeholder="Search" className="mr-sm-2"/>
                    </Col>
                    <Col>
                        <Button variant="outline-secondary" type="button">Search</Button>   
                    </Col>
                    </Row>
                </Form.Group>               
            </Form>
        </>
        
    );
};

export default SearchForm;