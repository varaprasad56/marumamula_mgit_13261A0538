import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * A fix-sized array of students array length should always be equal to the
 * number of stored elements after the element was removed the size of the array
 * should be equal to the number of stored elements after the element was added
 * the size of the array should be equal to the number of stored elements null
 * elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given
 * class, interface or method DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;

	/**
	 * DO NOT remove or change this constructor, it will be used during task
	 * check
	 * 
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {

		return students;
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
		if (students == null) {
			throw new IllegalArgumentException();
		} else {
			this.students = students;
		}
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
		if (index < 0 || index >= this.students.length) {
			throw new IllegalArgumentException();
		}
		return this.students[index];
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
		if (student == null || index < 0 || index >= this.students.length) {
			throw new IllegalArgumentException();
		} else {
			for (int i = 0; i < students.length; i++) {
				if (i == index) {
					students[i] = student;
				}
			}
		}
	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
		if (student == null) {
			throw new IllegalArgumentException();
		} else {
			List<Student> li = new ArrayList<Student>(Arrays.asList(students));
			li.add(0, student);
			this.students = li.toArray(new Student[li.size()]);
		}
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
		if (student == null) {
			throw new IllegalArgumentException();
		} else {
			List<Student> li = new ArrayList<Student>(Arrays.asList(students));
			li.add(student);
			this.students = li.toArray(new Student[li.size()]);
		}
	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
		if (student == null || index < 0 || index >= this.students.length) {
			throw new IllegalArgumentException();
		} else {
			List<Student> li = new ArrayList<Student>(Arrays.asList(students));
			li.add(index, student);
			this.students = li.toArray(new Student[li.size()]);
		}
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
		if (index < 0 || index >= this.students.length) {
			throw new IllegalArgumentException();
		} else {
			List<Student> li = new ArrayList<Student>(Arrays.asList(students));
			li.remove(index);
			this.students = li.toArray(new Student[li.size()]);
		}

	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
		if (student == null) {
			throw new IllegalArgumentException();
		}
		List<Student> li = new ArrayList<Student>(Arrays.asList(students));
		if (li.contains(student)) {
			li.remove(student);
			this.students = li.toArray(new Student[li.size()]);
		} else {
			throw new IllegalArgumentException("Student not exist");
		}
	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
		if (index < 0 || index >= this.students.length) {
			throw new IllegalArgumentException();
		} else {
			List<Student> li = new ArrayList<Student>(Arrays.asList(students));
			List<Student> lst2 = new ArrayList<Student>();
			for (int i = 0; i <= index; i++) {
				lst2.add(li.get(i));
			}
			this.students = lst2.toArray(new Student[lst2.size()]);
		}
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
		if (student == null) {
			throw new IllegalArgumentException();
		} else {
			List<Student> li = new ArrayList<Student>(Arrays.asList(students));
			List<Student> lst2 = new ArrayList<Student>();
			for (int i = 0; i < students.length; i++) {
				lst2.add(li.get(i));
				if (student == li.get(i)) {
					break;
				}

			}
			this.students = lst2.toArray(new Student[lst2.size()]);
		}
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
		if (index < 0 || index >= this.students.length) {
			throw new IllegalArgumentException();
		} else {
			List<Student> li = new ArrayList<Student>(Arrays.asList(students));
			List<Student> lst2 = new ArrayList<Student>();
			for (int i = index; i < this.students.length; i++) {
				lst2.add(li.get(i));
			}
			this.students = lst2.toArray(new Student[lst2.size()]);
		}
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
		if (student == null) {
			throw new IllegalArgumentException();
		} else {
			List<Student> li = new ArrayList<Student>(Arrays.asList(students));
			List<Student> lst2 = new ArrayList<Student>();
			int flag = 0;
			for (int i = 0; i < this.students.length; i++) {
				if (li.get(i) == student)
					flag = 1;
				if (flag == 1)
					lst2.add(li.get(i));

			}
			this.students = lst2.toArray(new Student[lst2.size()]);
		}
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		int n = this.students.length;
		Student temp = null;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (this.students[j - 1].getId() > this.students[j].getId()) {
					// swap elements
					temp = this.students[j - 1];
					this.students[j - 1] = this.students[j];
					this.students[j] = temp;
				}
			}
		}
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		ArrayList<Student> al = new ArrayList<Student>();
		for (int i = 0; i < students.length; i++) {
			int res = date.compareTo(students[i].getBirthDate());
			if (res == 0) {
				al.add(students[i]);
			}
		}
		Student[] studs = al.toArray(new Student[al.size()]);

		return studs;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		ArrayList<Student> al = new ArrayList<Student>();
		for (int i = 0; i < students.length; i++) {
			if (students[i].getBirthDate().after(firstDate) && students[i].getBirthDate().before(lastDate)) {
				al.add(students[i]);
			}

		}
		Student[] studs = al.toArray(new Student[al.size()]);

		return studs;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		ArrayList<Student> al = new ArrayList<Student>();
		long specificdate = date.getTime();
		long datewithrange = specificdate + days * 24 * 60 * 60 * 1000;
		for (int i = 0; i < students.length; i++) {
			long studtime = students[i].getBirthDate().getTime();
			if (studtime == specificdate || (studtime > specificdate) && (studtime <= datewithrange)) {
				al.add(students[i]);
			}
		}
		Student[] studswithrange = al.toArray(new Student[al.size()]);
		return studswithrange;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		Calendar birth = Calendar.getInstance();
		birth.setTime(students[indexOfStudent].getBirthDate());
		Calendar today = Calendar.getInstance();

		int yearDifference = today.get(Calendar.YEAR) - birth.get(Calendar.YEAR);

		if (today.get(Calendar.MONTH) < birth.get(Calendar.MONTH)) {
			yearDifference--;
		} else {
			if (today.get(Calendar.MONTH) == birth.get(Calendar.MONTH)
					&& today.get(Calendar.DAY_OF_MONTH) < birth.get(Calendar.DAY_OF_MONTH)) {
				yearDifference--;
			}

		}

		return yearDifference;

	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		ArrayList<Student> al = new ArrayList<Student>();
		for (int i = 0; i < students.length; i++) {
			if (getCurrentAgeByDate(i) == age) {
				al.add(students[i]);
			}
		}
		Student[] studsbyage = al.toArray(new Student[al.size()]);
		return studsbyage;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		double max = 0.0f;
		for (int i = 0; i < students.length; i++) {
			if (students[i].getAvgMark() > max) {
				max = students[i].getAvgMark();
			}
		}
		List<Student> li = new ArrayList<Student>();
		for (int i = 0; i < students.length; i++) {
			if (students[i].getAvgMark() == max)
				li.add(students[i]);
		}
		Student[] highMarks = li.toArray(new Student[li.size()]);
		return highMarks;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		if (student == null) {
			throw new IllegalArgumentException();
		} else {
			int i;
			for (i = 0; i < students.length; i++) {
				if (students[i] == student) {
					break;
				}
			}
			if ((i + 1) >= students.length)
				return null;
			else
				return students[i + 1];
		}
	}
}
