import React, { useState } from 'react';
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import Form from 'react-bootstrap/Form';

function LogInModal(props) {

  return (
    <>
    <Modal {...props} centered>
        <Modal.Header closeButton>
            <Modal.Title>Log In</Modal.Title>
        </Modal.Header>
        <Modal.Body>
            <Form>
            <Form.Group>
            <Form.Control type="email" placeholder="Email"/>
            <Form.Control type="password" placeholder="Password"/>
            <Button variant='outline-secondary' type='button'>Login</Button>
            </Form.Group>
            </Form>
        </Modal.Body>
        <Modal.Footer>
            <span>Not registered yet?</span>
            <a class="btn btn-success" role="button" href="#">Sign Up</a>
        </Modal.Footer>
    </Modal>
    </>
  );
}

export default LogInModal;