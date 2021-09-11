import math


def cal_fee(fees, time):
    if time <= fees[0]: return fees[1]
    else:  return fees[1] + math.ceil((time - fees[0]) / fees[2]) * fees[3]


def str_to_int(time):
    h, m = time.split(':')
    return int(h) * 60 + int(m)


def solution(fees, records):
    answer = []
    cars = {}
    for record in records:
        time, car_number, in_out = record.split()
        if car_number not in cars:
            cars[car_number] = [str_to_int(time)]
        else:
            cars[car_number] += [str_to_int(time)]
    s_sort = sorted(cars.items())
    for car in s_sort:
        time = 0
        for i in range(0, len(car[1]), 2):
            if i + 1 == len(car[1]):
                time += str_to_int("23:59") - car[1][i]
            else:
                time += car[1][i + 1] - car[1][i]
        answer.append(cal_fee(fees, time))
    return answer


print(solution([180, 5000, 10, 600],
               ["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN",
                "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]))
