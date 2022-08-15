import React from 'react';
import Button from 'react-bootstrap/Button';
import LogInModal from './LogInModal';

function NavLoginButton() {

    const [modalShow, setModalShow] = React.useState(false);

  return (
    <>
      <Button variant="outline-secondary" onClick={() => setModalShow(true)}>
        Log In/Sign Up
      </Button>

      <LogInModal
        show={modalShow}
        onHide={() => setModalShow(false)}
      />
    </>
  );
}

export default NavLoginButton;