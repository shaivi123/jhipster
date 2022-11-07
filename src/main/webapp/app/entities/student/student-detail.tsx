import React, { useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { ICrudGetAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './student.reducer';
import { IStudent } from 'app/shared/model/student.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IStudentDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export const StudentDetail = (props: IStudentDetailProps) => {
  useEffect(() => {
    props.getEntity(props.match.params.id);
  }, []);

  const { studentEntity } = props;
  return (
    <Row>
      <Col md="8">
        <h2>
          Student [<b>{studentEntity.id}</b>]
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="name">Name</span>
          </dt>
          <dd>{studentEntity.name}</dd>
          <dt>
            <span id="age">Age</span>
          </dt>
          <dd>{studentEntity.age}</dd>
          <dt>
            <span id="email">Email</span>
          </dt>
          <dd>{studentEntity.email}</dd>
          <dt>
            <span id="phone">Phone</span>
          </dt>
          <dd>{studentEntity.phone}</dd>
          <dt>
            <span id="address">Address</span>
          </dt>
          <dd>{studentEntity.address}</dd>
          <dt>
            <span id="pinCode">Pin Code</span>
          </dt>
          <dd>{studentEntity.pinCode}</dd>
        </dl>
        <Button tag={Link} to="/student" replace color="info">
          <FontAwesomeIcon icon="arrow-left" /> <span className="d-none d-md-inline">Back</span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/student/${studentEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" /> <span className="d-none d-md-inline">Edit</span>
        </Button>
      </Col>
    </Row>
  );
};

const mapStateToProps = ({ student }: IRootState) => ({
  studentEntity: student.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(StudentDetail);
