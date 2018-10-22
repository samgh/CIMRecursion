Schedule = collections.namedtuple('Schedule', ('schedule','value'))
class ConsultantSchedule():
	def consultant_schedule(self, ny, bos):
		new_york = self.consultant_schedule_new_york(ny, bos, 0)
		boston = self.consultant_schedule_boston(ny, bos, 0)
		if new_york.value > boston.value:
			return new_york.schedule
		return boston.schedule

	def consultant_schedule_boston(self, ny, bos, i):
		if i >= len(ny):
			return Schedule("", 0)

		stay = self.consultant_schedule_boston(ny, bos, i + 1)
		move = self.consultant_schedule_new_york(ny, bos, i + 1)

		if stay.value + bos[i] > move.value:
			return Schedule("B" + stay.schedule, stay.value + bos[i])
		return Schedule("T" + move.schedule, move.value)

	def consultant_schedule_new_york(self, ny, bos, i):
		if i >= len(ny):
			return Schedule("", 0)

		stay = self.consultant_schedule_boston(ny, bos, i + 1)
		move = self.consultant_schedule_new_york(ny, bos, i + 1)

		if stay.value + ny[i] > move.value:
			return Schedule("N" + stay.schedule, stay.value + ny[i])
		return Schedule("T" + move.schedule, move.value)

test = ConsultantSchedule()
print(test.consultant_schedule([1,2,3,4,4,3,2,1], [4,3,2,1,1,2,3,4]))
