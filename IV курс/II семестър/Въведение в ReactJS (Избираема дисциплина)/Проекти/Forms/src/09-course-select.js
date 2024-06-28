import PropTypes from "prop-types";
/* eslint no-underscore-dangle: [2, { "allow": ["_loading"] }] */
import React from "react";
import Core from "./api/core.json";
import Electives from "./api/electives.json";
import { useState } from "react";

const Courses = {
  core: Core,
  electives: Electives,
};

function CourseSelect(props) {
  const [department, setDepartment] = useState(null);
  const [course, setCourse] = useState(null);
  const [courses, setCourses] = useState([]);
  const [_loading, _setLoading] = useState(false);

  if (department !== props.department) {
    setDepartment(props.department);
  }

  if (course !== props.course) {
    setCourse(props.course);
  }

  let onSelectDepartment = (evt) => {
    const department = evt.target.value;
    const course = null;
    setDepartment(department);
    setCourse(course);
    props.onChange({ name: "course", value: course });
    props.onChange({ name: "department", value: department });

    if (department) fetch(department);
  };

  let onSelectCourse = (evt) => {
    const course = evt.target.value;
    if (!course) return;
    setCourse(course);
    props.onChange({ name: "course", value: course });
  };

  let fetch = (department) => {
    _setLoading(true);
    setCourses([]);
    apiClient(department).then((courses) => {
      _setLoading(false);
      setCourses(courses);
    });
  };

  let renderDepartmentSelect = () => {
    return (
      <select onChange={onSelectDepartment} value={department || ""}>
        <option value="">Which department?</option>
        <option value="core">NodeSchool: Core</option>
        <option value="electives">NodeSchool: Electives</option>
      </select>
    );
  };

  let renderCourseSelect = () => {
    if (_loading) {
      return <img alt="loading" src="/img/loading.gif" />;
    }
    if (!department || !courses.length) return <span />;

    return (
      <select onChange={onSelectCourse} value={course || ""}>
        {[
          <option value="" key="course-none">
            Which course?
          </option>,

          ...courses.map((course, i) => (
            <option value={course} key={i}>
              {course}
            </option>
          )),
        ]}
      </select>
    );
  };

  return (
    <div>
      {renderDepartmentSelect()}
      <br />
      {renderCourseSelect()}
    </div>
  );
}

CourseSelect.propTypes = {
  department: PropTypes.string,
  course: PropTypes.string,
  onChange: PropTypes.func.isRequired,
};

export default CourseSelect;

function apiClient(department) {
  return {
    then: function (cb) {
      setTimeout(() => {
        cb(Courses[department]);
      }, 1000);
    },
  };
}
