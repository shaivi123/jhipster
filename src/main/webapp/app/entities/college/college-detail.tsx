import React, { useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { ICrudGetAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './college.reducer';
import { ICollege } from 'app/shared/model/college.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface ICollegeDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export const CollegeDetail = (props: ICollegeDetailProps) => {
  useEffect(() => {
    props.getEntity(props.match.params.id);
  }, []);

  const { collegeEntity } = props;
  return (
    <Row>
      <Col md="8">
        <h2>
          College [<b>{collegeEntity.id}</b>]
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="clgName">Clg Name</span>
          </dt>
          <dd>{collegeEntity.clgName}</dd>
          <dt>
            <span id="course">Course</span>
          </dt>
          <dd>{collegeEntity.course}</dd>
        </dl>
        <Button tag={Link} to="/college" replace color="info">
          <FontAwesomeIcon icon="arrow-left" /> <span className="d-none d-md-inline">Back</span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/college/${collegeEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" /> <span className="d-none d-md-inline">Edit</span>
        </Button>
      </Col>
    </Row>
  );
};

const mapStateToProps = ({ college }: IRootState) => ({
  collegeEntity: college.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(CollegeDetail);
